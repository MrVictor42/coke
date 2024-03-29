/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package br.com.victor.coke.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchCokeException extends NoSuchModelException {

	public NoSuchCokeException() {
	}

	public NoSuchCokeException(String msg) {
		super(msg);
	}

	public NoSuchCokeException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchCokeException(Throwable throwable) {
		super(throwable);
	}

}