package com.own.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

import com.lifeway.dlt.constant.MessageKeyConstant;
import com.lifeway.dlt.model.view.User;

/**
 * Implementation class for Change Password Service.
 * 
 * @author Ankita.Madan
 */
@Service
public class ValidatorUtil {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-zA-Z]).{7,})";

	private static final String GROUP_NAME_REGEX = "[a-zA-Z0-9:,()\\.\\-_\\s]*";

	/**
	 * Pattern matcher.
	 * 
	 * @param inputString
	 *            the input string
	 * @param regex
	 *            the regex
	 * @return true, if successful
	 */
	private static boolean patternMatcher(final String inputString,
			final String regex) {
		if (inputString == null || regex == null) {
			return false;
		}
		Matcher matcher;
		Pattern pattern = Pattern.compile(regex);
		matcher = pattern.matcher(inputString);
		return matcher.matches();

	}

	public static boolean validateEmail(final String emailId) {

		return patternMatcher(emailId, EMAIL_PATTERN);
	}

	public static boolean validatePassword(final String password) {

		return patternMatcher(password, PASSWORD_PATTERN);
	}

	public static boolean validateGroupNameLength(final String groupName) {
		String groupNameTrimmed = StringUtils.trimWhitespace(groupName);
		return (groupNameTrimmed == null ? 0 : groupNameTrimmed.length()) > 64 ? false
				: true;

	}

	/**
	 * Validate group name.
	 * 
	 * @param groupName
	 *            the group name
	 * @return true, if successful
	 */
	public static boolean validateGroupNamePattern(final String groupName) {

		return patternMatcher(StringUtils.trimWhitespace(groupName),
				GROUP_NAME_REGEX);

	}

	/**
	 * Validate email.
	 * 
	 * @param emailId
	 *            the email id
	 * @return true, if successful
	 */

	/**
	 * Validate email list.
	 * 
	 * @param emailIds
	 *            the email ids
	 * @return true, if successful
	 */
	public boolean validateEmailList(final String emailIds) {
		boolean isValid = true;
		String[] emailList = emailIds.split("\\s*,\\s*");
		for (String emailId : emailList) {
			isValid &= validateEmail(emailId);
		}

		return isValid;
	}

	/**
	 * Validate recover password.
	 * 
	 * @param user
	 *            the user
	 * @param errors
	 *            the errors
	 */
	public void validateRecoverPassword(final User user, final Errors errors) {

		String emailAddress = user.getEmailAddress();

		if (!(StringUtils.hasLength(user.getEmailAddress()) && validateEmail(emailAddress))) {
			errors.rejectValue("emailAddress",
					MessageKeyConstant.EMAIL_MALFORMED_KEY);
			errors.rejectValue("emailAddress", MessageKeyConstant.USER_NOTVALID);
		}

	}

}
