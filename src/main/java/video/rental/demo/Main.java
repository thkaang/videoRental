package video.rental.demo;

import video.rental.demo.application.Interactor;
import video.rental.demo.domain.Repository;
import video.rental.demo.infrastructure.RepositoryMemImpl;
import video.rental.demo.presentation.CmdUI;
import video.rental.demo.presentation.GraphicUI;
import video.rental.demo.util.SampleGenerator;

public class Main {
	private static final boolean isGraphic = true;

	public static void main(String[] args) {
		Repository repository = new RepositoryMemImpl();
		new SampleGenerator(repository).generateSamples();

		if (isGraphic) {
			Interactor interactor = new Interactor(repository);
			GraphicUI graphicUI = new GraphicUI(interactor);
			graphicUI.start();
		}
		else {
			Interactor interactor = new Interactor(repository);
			CmdUI cmdUI = new CmdUI(interactor);
			cmdUI.start();
		}
	}
}
