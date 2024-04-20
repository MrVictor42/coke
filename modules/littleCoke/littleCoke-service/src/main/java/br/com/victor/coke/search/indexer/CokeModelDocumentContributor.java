package br.com.victor.coke.search.indexer;

import br.com.victor.coke.constants.CokeConstants;
import br.com.victor.coke.model.Coke;
import br.com.victor.coke.model.UserCoke;
import br.com.victor.coke.model.dto.UserCokeDTO;
import br.com.victor.coke.model.dto.UserDTO;
import br.com.victor.coke.service.UserCokeLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.IndexWriterHelper;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;

@Component(
    immediate = true,
    property = "indexer.class.name=" + CokeConstants.COKE_MODEL,
    service = ModelDocumentContributor.class
)
public class CokeModelDocumentContributor implements ModelDocumentContributor<Coke> {

    private final static String COMPANY_ID = "companyId";
    private final static String COKE_ID = "cokeId";
    private final static String COKE_NAME = "cokeName";

    // CREATOR INFORMATION'S
    private final static String CREATOR = "creator";
    private final static String USER_COKE = "userCoke";

    @Override
    public void contribute(Document document, Coke coke) {
        try {
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
        } catch (PortalException e) {
            _log.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    private final Log _log = LogFactoryUtil.getLog(CokeModelDocumentContributor.class);

    @Reference
    protected IndexWriterHelper indexWriterHelper;

    @Reference
    private UserCokeLocalService userCokeLocalService;

    @Reference
    private UserLocalService userLocalService;
}