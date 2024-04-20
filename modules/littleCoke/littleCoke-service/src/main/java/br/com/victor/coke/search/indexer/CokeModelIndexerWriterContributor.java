package br.com.victor.coke.search.indexer;

import br.com.victor.coke.constants.CokeConstants;
import br.com.victor.coke.model.Coke;
import br.com.victor.coke.service.CokeLocalService;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
    immediate = true,
    property = "indexer.class.name=" + CokeConstants.COKE_MODEL,
    service = ModelIndexerWriterContributor.class
)
public class CokeModelIndexerWriterContributor implements ModelIndexerWriterContributor<Coke> {

    @Override
    public void customize(BatchIndexingActionable batchIndexingActionable, ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
        batchIndexingActionable.setPerformActionMethod(
            (Coke coke) -> {
                Document document = modelIndexerWriterDocumentHelper.getDocument(coke);
                batchIndexingActionable.addDocuments(document);
            }
        );
    }
    @Override
    public BatchIndexingActionable getBatchIndexingActionable() {
        return dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(cokeLocalService.getIndexableActionableDynamicQuery());
    }
    @Override
    public long getCompanyId(Coke coke) {
        return coke.getCompanyId();
    }

    @Reference
    protected CokeLocalService cokeLocalService;

    @Reference
    protected DynamicQueryBatchIndexingActionableFactory dynamicQueryBatchIndexingActionableFactory;
}