package br.com.victor.littleCoke.web.internal.asset;

import br.com.victor.coke.constants.CokeConstants;
import br.com.victor.coke.model.Coke;
import br.com.victor.coke.service.CokeLocalService;
import br.com.victor.littleCoke.web.internal.security.permission.resource.CokePermission;
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.servlet.ServletContext;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + CokeConstants.LITTLE_COKE_WEB
    },
    service = AssetRendererFactory.class
)
public class CokeAssetRendererFactory extends BaseAssetRendererFactory<Coke> {

    public CokeAssetRendererFactory() {
        setClassName(CLASS_NAME);
        setLinkable(_LINKABLE);
        setPortletId(CokeConstants.LITTLE_COKE_WEB);
        setSearchable(true);
        setSelectable(true);
    }

    @Override
    public AssetRenderer<Coke> getAssetRenderer(long classPK, int type) throws PortalException {
        Coke coke = _cokeLocalService.getCoke(classPK);
        CokeAssetRenderer cokeAssetRenderer = new CokeAssetRenderer(coke, _cokeModelResourcePermission);

        cokeAssetRenderer.setAssetRendererType(type);
        cokeAssetRenderer.setServletContext(_servletContext);

        return cokeAssetRenderer;
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public String getClassName() {
        return CLASS_NAME;
    }

    @Override
    public boolean hasPermission(PermissionChecker permissionChecker, long classPK, String actionId) throws Exception {
        Coke coke = _cokeLocalService.getCoke(classPK);
        long groupId = coke.getGroupId();

        return CokePermission.contains(permissionChecker, groupId, actionId);
    }

    @Override
    public PortletURL getURLAdd(LiferayPortletRequest liferayPortletRequest, LiferayPortletResponse liferayPortletResponse, long classTypeId) {
        PortletURL portletURL = null;

        try {
            ThemeDisplay themeDisplay = (ThemeDisplay) liferayPortletRequest.getAttribute(WebKeys.THEME_DISPLAY);

            portletURL = liferayPortletResponse.createLiferayPortletURL(getControlPanelPlid(themeDisplay), CokeConstants.LITTLE_COKE_WEB, PortletRequest.RENDER_PHASE);
            portletURL.setParameter("mvcPath", "/coke/edit_coke.jsp");
            portletURL.setParameter("showback", Boolean.FALSE.toString());

        } catch (PortalException e) {
            _logger.log(Level.SEVERE, e.getMessage());
        }

        return portletURL;
    }

    @Override
    public boolean isLinkable() {
        return _LINKABLE;
    }

    @Override
    public String getIconCssClass() {
        return "bookmarks";
    }

    @Reference(target = "(osgi.web.symbolicname=" + CokeConstants.SYMBOLIC_NAME + ")", unbind = "-")
    public void setServletContext(ServletContext servletContext) {
        _servletContext = servletContext;
    }

    @Reference(unbind = "-")
    protected void setGuestbookLocalService(CokeLocalService cokeLocalService) {
        _cokeLocalService = cokeLocalService;
    }

    private ServletContext _servletContext;
    private CokeLocalService _cokeLocalService;
    private static final boolean _LINKABLE = true;
    public static final String CLASS_NAME = Coke.class.getName();
    public static final String TYPE = "coke";
    private final Logger _logger = Logger.getLogger(this.getClass().getName());
    private ModelResourcePermission<Coke> _cokeModelResourcePermission;
}