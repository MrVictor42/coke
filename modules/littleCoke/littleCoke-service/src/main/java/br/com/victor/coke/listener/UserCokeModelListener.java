package br.com.victor.coke.listener;

import br.com.victor.coke.config.monday.MondayConfiguration;
import br.com.victor.coke.constants.CokeConstants;
import br.com.victor.coke.constants.MondayConstants;
import br.com.victor.coke.model.UserCoke;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Component(
    configurationPid = MondayConstants.PID_MONDAY_CONFIGURATION,
    immediate = true,
    service = ModelListener.class
)
public class UserCokeModelListener extends BaseModelListener<UserCoke> {

    @Override
    public void onAfterUpdate(UserCoke originalModel, UserCoke userCoke) throws ModelListenerException {
        if (userCoke.getOrder() == CokeConstants.NEXT_TO_PAY) {

        }

        super.onAfterUpdate(originalModel, userCoke);
    }

    private final Log _log = LogFactoryUtil.getLog(UserCokeModelListener.class);

    @Activate
    @Modified
    protected void activate(Map<String, Object> properties) {
        _mondayConfiguration = ConfigurableUtil.createConfigurable(MondayConfiguration.class, properties);
    }
    private volatile MondayConfiguration _mondayConfiguration;

    @Reference
    private UserLocalService _userLocalService;
}