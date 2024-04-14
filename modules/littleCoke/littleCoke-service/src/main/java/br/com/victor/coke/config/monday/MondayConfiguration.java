package br.com.victor.coke.config.monday;

import aQute.bnd.annotation.metatype.Meta;
import br.com.victor.coke.constants.MondayConstants;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(
    category = MondayConstants.CATEGORY_KEY,
    scope = ExtendedObjectClassDefinition.Scope.SYSTEM
)

@Meta.OCD(
    id = MondayConstants.PID_MONDAY_CONFIGURATION,
    name = MondayConstants.MONDAY_CONFIGURATION_NAME
)
public interface MondayConfiguration {

    @Meta.AD(
        name = "Monday API", required = false
    )
    public String getMondayAPI();

    @Meta.AD(
        name = "Token", required = false
    )
    public String getToken();
}