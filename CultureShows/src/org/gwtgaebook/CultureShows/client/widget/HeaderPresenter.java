package org.gwtgaebook.CultureShows.client.widget;

import org.gwtgaebook.CultureShows.client.ClientState;
import org.gwtgaebook.CultureShows.client.Main;
import org.gwtgaebook.CultureShows.client.event.UserInfoAvailableEvent;
import org.gwtgaebook.CultureShows.client.event.UserInfoAvailableEvent.UserInfoAvailableHandler;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.proxy.PlaceManager;

public class HeaderPresenter extends PresenterWidget<HeaderPresenter.MyView>
		implements HeaderUiHandlers {

	public interface MyView extends View, HasUiHandlers<HeaderUiHandlers> {
		public void setClientState(ClientState clientState);
	}

	private final PlaceManager placeManager;
	private ClientState clientState;

	@Inject
	public HeaderPresenter(final EventBus eventBus, final MyView view,
			final PlaceManager placeManager) {
		super(eventBus, view);
		getView().setUiHandlers(this);

		this.placeManager = placeManager;
	}

	@Override
	protected void onBind() {
		super.onBind();

		addRegisteredHandler(UserInfoAvailableEvent.getType(),
				new UserInfoAvailableHandler() {
					@Override
					public void onHasUserInfoAvailable(
							UserInfoAvailableEvent event) {
						onUserInfoAvailable(event.getClientState());

					}
				});
	}

	@Override
	public void onReveal() {
		super.onReveal();
		Main.logger.info("HeaderPresenter onReveal");
	}

	public void onUserInfoAvailable(ClientState clientState) {
		this.clientState = clientState;
		getView().setClientState(clientState);
		// TODO set theaters
	}

}