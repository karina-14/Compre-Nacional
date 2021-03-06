package org.example.kickoff.view.admin;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.example.kickoff.business.service.UserService;
import org.example.kickoff.model.User;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.optimusfaces.model.PagedDataModel;

@Named
@ViewScoped
public class UsersBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	private PagedDataModel<User> users;

	@Inject
	private UserService userService;

	@PostConstruct
	public void init() {
		users = PagedDataModel.forClass(User.class).withDefaultSortField("created").build();
	}

	public void delete(User user) {
		userService.delete(user);
	}

	public PagedDataModel<User> getUsers() {
		return users;
	}

}