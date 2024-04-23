package br.com.victor.coke.config.coke;

import aQute.bnd.annotation.metatype.Meta;
import br.com.victor.coke.constants.CokeConstants;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(
    category = CokeConstants.CATEGORY_KEY,
    scope = ExtendedObjectClassDefinition.Scope.SYSTEM
)

@Meta.OCD(
    id = CokeConstants.PID_COKE_CONFIGURATION,
    name = CokeConstants.COKE_CONFIGURATION_NAME
)
public interface CokeConfiguration {

    @Meta.AD(
        name = "Monday API", required = false
    )
    String getMondayAPI();

    @Meta.AD(
        name = "Token", required = false
    )
    String getToken();

    @Meta.AD(
            name = "API Webhook Discord", required = false
    )
    String getWebhookDiscordAPI();

    @Meta.AD(
            name = "Avatar Webhook Discord", required = false
    )
    String getAvatarURLDiscord();
}