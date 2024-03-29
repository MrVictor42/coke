/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.victor.coke.model.impl;

import br.com.victor.coke.model.Coke;
import br.com.victor.coke.service.CokeLocalServiceUtil;

/**
 * The extended model base implementation for the Coke service. Represents a row in the &quot;Coke_Coke&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CokeImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CokeImpl
 * @see Coke
 * @generated
 */
public abstract class CokeBaseImpl extends CokeModelImpl implements Coke {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a coke model instance should use the <code>Coke</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			CokeLocalServiceUtil.addCoke(this);
		}
		else {
			CokeLocalServiceUtil.updateCoke(this);
		}
	}

}