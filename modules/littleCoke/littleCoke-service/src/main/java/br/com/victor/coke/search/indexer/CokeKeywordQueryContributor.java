package br.com.victor.coke.search.indexer;

import br.com.victor.coke.constants.CokeConstants;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.search.query.QueryHelper;
import com.liferay.portal.search.spi.model.query.contributor.KeywordQueryContributor;
import com.liferay.portal.search.spi.model.query.contributor.helper.KeywordQueryContributorHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
    immediate = true,
    property = "indexer.class.name=" + CokeConstants.COKE_MODEL,
    service = KeywordQueryContributor.class
)
public class CokeKeywordQueryContributor implements KeywordQueryContributor {

    private final static String COMPANY_ID = "companyId";
    private final static String COKE_ID = "cokeId";
    private final static String COKE_NAME = "cokeName";

    // CREATOR INFORMATION'S
    private final static String CREATOR = "creator";
    private final static String USER_COKE = "userCoke";

    @Override
    public void contribute(String keywords, BooleanQuery booleanQuery, KeywordQueryContributorHelper keywordQueryContributorHelper) {
        SearchContext searchContext = keywordQueryContributorHelper.getSearchContext();

        queryHelper.addSearchTerm(booleanQuery, searchContext, COMPANY_ID, true);
        queryHelper.addSearchTerm(booleanQuery, searchContext, COKE_ID, true);
        queryHelper.addSearchTerm(booleanQuery, searchContext, Field.USER_NAME, true);
        queryHelper.addSearchTerm(booleanQuery, searchContext, COKE_NAME, true);
        queryHelper.addSearchTerm(booleanQuery, searchContext, CREATOR, true);
        queryHelper.addSearchTerm(booleanQuery, searchContext, USER_COKE, true);
    }

    @Reference
    protected QueryHelper queryHelper;
}