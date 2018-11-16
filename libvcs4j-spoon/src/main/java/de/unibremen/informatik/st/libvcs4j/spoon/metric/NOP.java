package de.unibremen.informatik.st.libvcs4j.spoon.metric;

import spoon.reflect.declaration.CtConstructor;
import spoon.reflect.declaration.CtExecutable;
import spoon.reflect.declaration.CtMethod;

import java.util.Optional;

/**
 * This scanner gathers the 'Number of Parameters' metric for {@link CtMethod}
 * and {@link CtConstructor} elements.
 */
public class NOP extends IntGatherer {

	@Override
	protected String name() {
		return "NOP";
	}

	@Override
	protected String abbreviation() {
		return "Number of Parameters";
	}

	/**
	 * Returns the 'Number of Parameters' metric of {@code executable}. Returns
	 * an empty {@link Optional} if {@code executable} is {@code null}, or if
	 * {@code executable} was not scanned.
	 *
	 * @param executable
	 * 		The executable whose 'Number of Parameters' metric is requested.
	 * @return
	 * 		The 'Number of Parameters' metric of {@code executable}.
	 */
	public Optional<Integer> NOPOf(final CtExecutable executable) {
		return metricOf(executable);
	}

	@Override
	public <T> void visitCtMethod(final CtMethod<T> method) {
		visitNode(method, Propagation.NONE, method.getParameters().size());
	}

	@Override
	public <T> void visitCtConstructor(final CtConstructor<T> constructor) {
		visitNode(constructor, Propagation.NONE,
				constructor.getParameters().size());
	}
}