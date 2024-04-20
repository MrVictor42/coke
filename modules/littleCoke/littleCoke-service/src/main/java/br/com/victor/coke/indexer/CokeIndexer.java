package br.com.victor.coke.indexer;

import br.com.victor.coke.model.Coke;
import br.com.victor.coke.model.UserCoke;
import br.com.victor.coke.model.dto.UserCokeDTO;
import br.com.victor.coke.model.dto.UserDTO;
import br.com.victor.coke.service.CokeLocalService;
import br.com.victor.coke.service.UserCokeLocalService;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.GetterUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import java.util.List;
import java.util.Locale;

@Component(
    immediate = true,
    service = Indexer.class
)

public class CokeIndexer extends BaseIndexer<Coke> {

    private final static String CLASS_NAME = Coke.class.getName();
    private final static String COMPANY_ID = "companyId";
    private final static String USER_ID = "userId";
    private final static String COKE_ID = "cokeId";
    private final static String COKE_NAME = "cokeName";

    // CREATOR INFORMATION'S
    private final static String CREATOR = "creator";
    private final static String USER_COKE = "userCoke";

    public CokeIndexer() {
        setDefaultSelectedFieldNames(Field.ENTRY_CLASS_PK, Field.NAME, COKE_ID, COMPANY_ID, COKE_NAME, CREATOR, USER_COKE);

        setFilterSearch(true);
        setPermissionAware(true);
    }

    @Override
    public String getClassName() {
        return CLASS_NAME;
    }

    @Override
    protected void doDelete(Coke coke) throws Exception {
        deleteDocument(coke.getCompanyId(), coke.getCokeId());
    }

    @Override
    public void postProcessSearchQuery(BooleanQuery searchQuery, BooleanFilter fullQueryBooleanFilter, SearchContext searchContext) throws Exception {
        addSearchTerm(searchQuery, searchContext, COMPANY_ID, true);
        addSearchTerm(searchQuery, searchContext, COKE_ID, true);
        addSearchTerm(searchQuery, searchContext, Field.USER_NAME, true);
        addSearchTerm(searchQuery, searchContext, COKE_NAME, true);
        addSearchTerm(searchQuery, searchContext, CREATOR, true);
        addSearchTerm(searchQuery, searchContext, USER_COKE, true);
    }

    @Override
    protected Document doGetDocument(Coke coke) throws PortalException {
        Document document = getBaseModelDocument(CLASS_NAME, coke);
        User user = userLocalService.getUser(coke.getUserId());
        List<UserCoke> userCokeList = userCokeLocalService.getUserCokeByCokeId(coke.getCokeId());
        UserDTO userDTO = new UserDTO();

        document.addKeywordSortable(COKE_ID, String.valueOf(coke.getCokeId()));
        document.addKeywordSortable(COMPANY_ID, String.valueOf(coke.getCompanyId()));
        document.addKeywordSortable(COKE_NAME, coke.getName());

        userDTO.setEmail(user.getEmailAddress());
        userDTO.setName(user.getFullName());
        userDTO.setUserId(user.getUserId());

        document.addKeywordSortable(CREATOR, userDTO.toString());

        for(UserCoke userCoke : userCokeList) {
            UserCokeDTO userCokeDTO = new UserCokeDTO();
            User userCokeDTOCurrent = userLocalService.getUser(userCoke.getUserId());
            UserDTO userCurrentDTO = new UserDTO();

            userCokeDTO.setUserCokeId(userCoke.getUserCokeId());
            userCokeDTO.setPosition(userCoke.getPosition());
            userCokeDTO.setOrder(userCoke.getOrder());

            userCurrentDTO.setEmail(userCokeDTOCurrent.getEmailAddress());
            userCurrentDTO.setUserId(userCokeDTOCurrent.getUserId());
            userCurrentDTO.setName(userCokeDTOCurrent.getFullName());

            userCokeDTO.setUserDTO(userCurrentDTO);

            document.addKeywordSortable(USER_COKE, userCokeDTO.toString());
        }


        return document;
    }

    @Override
    protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletRequest portletRequest, PortletResponse portletResponse) {
        Summary summary = createSummary(document);

        summary.setMaxContentLength(200);

        return summary;
    }

    @Override
    protected void doReindex(String className, long classPK) throws Exception {
        Coke coke = cokeLocalService.getCoke(classPK);

        doReindex(coke);
    }

    @Override
    protected void doReindex(Coke coke) throws Exception {
        Document document = getDocument(coke);

        indexWriterHelper.updateDocument(getSearchEngineId(), coke.getCompanyId(), document, isCommitImmediately());
    }

    @Override
    protected void doReindex(String[] ids) throws Exception {
        long companyId = GetterUtil.getLong(ids[0]);

        reindexAnnouncementFlag(companyId);
    }

    protected void reindexAnnouncementFlag(long companyId) throws PortalException {
        final IndexableActionableDynamicQuery indexableActionableDynamicQuery = cokeLocalService.getIndexableActionableDynamicQuery();

        indexableActionableDynamicQuery.setCompanyId(companyId);
        indexableActionableDynamicQuery.setPerformActionMethod(
                (ActionableDynamicQuery.PerformActionMethod<Coke>) coke -> {
                    try {
                        Document document = getDocument(coke);

                        indexableActionableDynamicQuery.addDocuments(document);
                    } catch (PortalException ignored) {

                    }
                });

        indexableActionableDynamicQuery.setSearchEngineId(getSearchEngineId());
        indexableActionableDynamicQuery.performActions();
    }

    @Reference
    protected IndexWriterHelper indexWriterHelper;

    @Reference
    private CokeLocalService cokeLocalService;

    @Reference
    private UserCokeLocalService userCokeLocalService;

    @Reference
    private UserLocalService userLocalService;
}