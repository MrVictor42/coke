/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.victor.coke.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Coke service. Represents a row in the &quot;Coke_Coke&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see CokeModel
 * @generated
 */
@ImplementationClassName("br.com.victor.coke.model.impl.CokeImpl")
@ProviderType
public interface Coke extends CokeModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>br.com.victor.coke.model.impl.CokeImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Coke, Long> COKE_ID_ACCESSOR =
		new Accessor<Coke, Long>() {

			@Override
			public Long get(Coke coke) {
				return coke.getCokeId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Coke> getTypeClass() {
				return Coke.class;
			}

		};

}