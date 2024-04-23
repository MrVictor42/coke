package br.com.victor.coke.config.coke;

import br.com.victor.coke.constants.CokeConstants;
import com.liferay.configuration.admin.category.ConfigurationCategory;
import org.osgi.service.component.annotations.Component;

@Component(service = ConfigurationCategory.class)
public class DynamicDataMappingConfigurationCategory implements ConfigurationCategory {

	
	@Override
	public String getCategoryIcon() {
		return CokeConstants.CATEGORY_ICON;
	}
	
	@Override
	public String getCategorySection() {
		return CokeConstants.CATEGORY_SECTION;
	}
	
	@Override
	public String getCategoryKey() {
		return CokeConstants.CATEGORY_KEY;
	}
}