package br.com.victor.littleCoke.web.internal.asset;

import br.com.victor.coke.constants.CokeConstants;
import br.com.victor.coke.model.Coke;
import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CokeAssetRenderer extends BaseJSPAssetRenderer<Coke> {

    public CokeAssetRenderer(Coke coke, ModelResourcePermission<Coke> cokeModelResourcePermission) {
        this._coke = coke;
        this._cokeModelResourcePermission = cokeModelResourcePermission;
    }

    @Override
    public Coke getAssetObject() {
        return _coke;
    }

    @Override
    public long getGroupId() {
        return _coke.getGroupId();
    }

    @Override
    public long getUserId() {
        return _coke.getUserId();
    }

    @Override
    public String getUserName() {
        return _coke.getName();
    }

    @Override
    public String getUuid() {
        return _coke.getUuid();
    }

    @Override
    public String getClassName() {
        return Coke.class.getName();
    }

    @Override
    public long getClassPK() {
        return _coke.getCokeId();
    }

    @Override
    public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
        return "Name: " + _coke.getName();
    }

    @Override
    public String getTitle(Locale locale) {
        return _coke.getName();
    }

    @Override
    public String getJspPath(HttpServletRequest httpServletRequest, String template) {

        if (template.equals(TEMPLATE_FULL_CONTENT)) {
            httpServletRequest.setAttribute("coke_coke", _coke);

            return "/asset/coke/" + template + ".jsp";
        } else {
            return null;
        }
    }

    @Override
    public PortletURL getURLEdit(LiferayPortletRequest liferayPortletRequest, LiferayPortletResponse liferayPortletResponse) throws Exception {

        PortletURL portletURL = liferayPortletResponse.createLiferayPortletURL(
            getControlPanelPlid(liferayPortletRequest), CokeConstants.LITTLE_COKE_WEB, PortletRequest.RENDER_PHASE
        );

        portletURL.setParameter("mvcPath", "/coke/edit_coke.jsp");
        portletURL.setParameter("cokeId", String.valueOf(_coke.getCokeId()));
        portletURL.setParameter("showback", Boolean.FALSE.toString());

        return portletURL;
    }

    @Override
    public String getURLViewInContext(LiferayPortletRequest liferayPortletRequest, LiferayPortletResponse liferayPortletResponse, String noSuchEntryRedirect) throws Exception {
        try {
            long plid = PortalUtil.getPlidFromPortletId(_coke.getGroupId(), CokeConstants.LITTLE_COKE_WEB);

            PortletURL portletURL;
            if (plid == LayoutConstants.DEFAULT_PLID) {
                portletURL = liferayPortletResponse.createLiferayPortletURL(getControlPanelPlid(liferayPortletRequest),
                        CokeConstants.LITTLE_COKE_WEB, PortletRequest.RENDER_PHASE);
            } else {
                portletURL = PortletURLFactoryUtil.create(liferayPortletRequest, CokeConstants.LITTLE_COKE_WEB, plid, PortletRequest.RENDER_PHASE);
            }

            portletURL.setParameter("mvcPath", "/coke/view_coke.jsp");
            portletURL.setParameter("cokeId", String.valueOf(_coke.getCokeId()));

            String currentUrl = PortalUtil.getCurrentURL(liferayPortletRequest);

            portletURL.setParameter("redirect", currentUrl);

            return portletURL.toString();

        } catch (PortalException | SystemException e) {
            _log.error(e.getMessage());
            _logger.log(Level.SEVERE, e.getMessage());

        }

        return noSuchEntryRedirect;
    }

    @Override
    public String getURLView(LiferayPortletResponse liferayPortletResponse, WindowState windowState) throws Exception {
        return super.getURLView(liferayPortletResponse, windowState);
    }

    @Override
    public boolean include(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String template) throws Exception {
        httpServletRequest.setAttribute("COKE", _coke);
        httpServletRequest.setAttribute("HtmlUtil", HtmlUtil.getHtml());
        httpServletRequest.setAttribute("StringUtil", new StringUtil());

        return super.include(httpServletRequest, httpServletResponse, template);

    }

    @Override
    public boolean hasEditPermission(PermissionChecker permissionChecker) {
        try {
            return _cokeModelResourcePermission.contains(permissionChecker, _coke, ActionKeys.UPDATE);
        } catch (Exception e) {
            _log.error(e.getMessage());
        }

        return false;
    }

    @Override
    public boolean hasViewPermission(PermissionChecker permissionChecker) {
        try {
            return _cokeModelResourcePermission.contains(permissionChecker, _coke, ActionKeys.VIEW);
        } catch (Exception e) {
            _log.error(e.getMessage());
        }

        return true;
    }

    private final Coke _coke;
    private final Log _log = LogFactoryUtil.getLog(CokeAssetRenderer.class);
    private final Logger _logger = Logger.getLogger(this.getClass().getName());
    private final ModelResourcePermission<Coke> _cokeModelResourcePermission;
}