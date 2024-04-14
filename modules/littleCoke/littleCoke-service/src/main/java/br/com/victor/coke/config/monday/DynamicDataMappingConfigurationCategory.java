package br.com.victor.coke.config.monday;

import br.com.victor.coke.constants.MondayConstants;
import com.liferay.configuration.admin.category.ConfigurationCategory;
import org.osgi.service.component.annotations.Component;

@Component(service = ConfigurationCategory.class)
public class DynamicDataMappingConfigurationCategory implements ConfigurationCategory {

	
	@Override
	public String getCategoryIcon() {
		return MondayConstants.CATEGORY_ICON;
	}
	
	@Override
	public String getCategorySection() {
		return MondayConstants.CATEGORY_SECTION;
	}
	
	@Override
	public String getCategoryKey() {
		return MondayConstants.CATEGORY_KEY;
	}
}