package br.com.victor.coke.schedule;

import br.com.victor.coke.config.monday.MondayConfiguration;
import br.com.victor.coke.constants.CokeConstants;
import br.com.victor.coke.constants.MondayConstants;
import br.com.victor.coke.model.Coke;
import br.com.victor.coke.model.UserCoke;
import br.com.victor.coke.service.CokeLocalService;
import br.com.victor.coke.service.UserCokeService;
import br.com.victor.coke.util.CokeUtil;
import com.liferay.dispatch.executor.BaseDispatchTaskExecutor;
import com.liferay.dispatch.executor.DispatchTaskExecutor;
import com.liferay.dispatch.executor.DispatchTaskExecutorOutput;
import com.liferay.dispatch.model.DispatchTrigger;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import java.util.*;

@Component(
    configurationPid = MondayConstants.PID_MONDAY_CONFIGURATION,
    property = {
        "dispatch.task.executor.name=" + CokeConstants.COKE_TASK_EXECUTOR_NAME,
        "dispatch.task.executor.type=" + CokeConstants.COKE_EXECUTOR_TYPE
    }, service = DispatchTaskExecutor.class
)

public class CokeTaskExecutor extends BaseDispatchTaskExecutor {

    @Override
    public void doExecute(DispatchTrigger dispatchTrigger, DispatchTaskExecutorOutput dispatchTaskExecutorOutput) {
        if (!CokeUtil.isConfigurationValid(dispatchTrigger, _mondayConfiguration)) {
            _log.error("A Configuração do Monday Não Está Completa");
            return;
        }

        List<Coke> cokeList = _cokeLocalService.getCokes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

        if(!cokeList.isEmpty()) {
            cokeList.forEach(coke -> {
                List<UserCoke> userCokeListOriginal = _userCokeService.getUserCokeByCokeId(coke.getCokeId());

                if(!userCokeListOriginal.isEmpty()) {
                    List<UserCoke> userCokeList = new ArrayList<>(userCokeListOriginal);

                    userCokeList.sort(Comparator.comparing(UserCoke::getOrder));

                    // Remove o primeiro elemento e o adiciona ao final da lista
                    UserCoke firstElement = userCokeList.remove(0);
                    userCokeList.add(firstElement);

                    for (int aux = 0; aux < userCokeList.size(); aux++) {
                        UserCoke userCoke = userCokeList.get(aux);

                        userCoke.setOrder(aux + 1);
                        _userCokeService.updateUserCokeOrder(userCoke.getUserCokeId(), userCoke.getOrder());
                    }
                }
            });
        }
    }

    @Override
    public String getName() {
        return CokeConstants.COKE_TASK_EXECUTOR_NAME;
    }

    @Activate
    @Modified
    protected void activate(Map<String, Object> properties) {
        _mondayConfiguration = ConfigurableUtil.createConfigurable(MondayConfiguration.class, properties);
    }
    private volatile MondayConfiguration _mondayConfiguration;

    private final Log _log = LogFactoryUtil.getLog(CokeTaskExecutor.class);

    @Reference
    private CokeLocalService _cokeLocalService;

    @Reference
    private UserCokeService _userCokeService;
}