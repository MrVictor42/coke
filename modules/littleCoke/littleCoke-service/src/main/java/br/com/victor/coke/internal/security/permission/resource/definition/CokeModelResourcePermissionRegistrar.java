package br.com.victor.coke.internal.security.permission.resource.definition;

import br.com.victor.coke.constants.CokeConstants;
import br.com.victor.coke.model.Coke;
import br.com.victor.coke.service.CokeLocalService;
import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.portal.kernel.security.permission.resource.*;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.portal.kernel.workflow.permission.WorkflowPermission;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import java.util.Dictionary;

@Component(immediate = true)
public class CokeModelResourcePermissionRegistrar {

    @Activate
    public void activate(BundleContext bundleContext) {
        Dictionary<String, Object> properties = new HashMapDictionary<>();

        properties.put("model.class.name", Coke.class.getName());

        _serviceRegistration = bundleContext.registerService(ModelResourcePermission.class,
                ModelResourcePermissionFactory.create(Coke.class, Coke::getCokeId,
                        _cokeLocalService::getCoke, _portletResourcePermission,
                        (modelResourcePermission, consumer) -> {
                            consumer.accept(new StagedModelPermissionLogic<>(_stagingPermission,
                                    CokeConstants.LITTLE_COKE_WEB, Coke::getCokeId));
                            consumer.accept(new WorkflowedModelPermissionLogic<>(_workflowPermission,
                                    modelResourcePermission, _groupLocalService, Coke::getCokeId));
                        }),
                properties);
    }

    @Deactivate
    public void deactivate() {
        _serviceRegistration.unregister();
    }

    @Reference
    private CokeLocalService _cokeLocalService;

    @Reference(target = "(resource.name=" + CokeConstants.RESOURCE_NAME + ")")
    private PortletResourcePermission _portletResourcePermission;

    private ServiceRegistration<ModelResourcePermission> _serviceRegistration;

    @Reference
    private StagingPermission _stagingPermission;

    @Reference
    private WorkflowPermission _workflowPermission;

    @Reference
    private GroupLocalService _groupLocalService;
}