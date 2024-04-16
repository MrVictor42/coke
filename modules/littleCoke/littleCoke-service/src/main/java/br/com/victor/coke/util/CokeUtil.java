package br.com.victor.coke.util;

import br.com.victor.coke.config.monday.MondayConfiguration;
import com.liferay.dispatch.model.DispatchTrigger;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class CokeUtil {

    public static boolean isConfigurationValid(DispatchTrigger dispatchTrigger, MondayConfiguration _mondayConfiguration) {
        if (dispatchTrigger == null || _mondayConfiguration.getToken().isEmpty() || _mondayConfiguration.getMondayAPI().isEmpty()) {
            _log.error("DispatchTrigger or Configuration is null");
            return false;
        }

        return true;
    }

    private static final Log _log = LogFactoryUtil.getLog(CokeUtil.class);
}