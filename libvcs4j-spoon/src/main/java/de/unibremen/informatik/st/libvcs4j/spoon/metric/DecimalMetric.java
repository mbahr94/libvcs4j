package de.unibremen.informatik.st.libvcs4j.spoon.metric;

import de.unibremen.informatik.st.libvcs4j.Validate;

import java.math.BigDecimal;

/**
 * A metric of type {@link BigDecimal}
 */
public class DecimalMetric extends Metric<BigDecimal> {

	@Override
	protected BigDecimal sum(final BigDecimal a, final BigDecimal b)
			throws NullPointerException {
		return Validate.notNull(a).add(Validate.notNull(b));
	}

	/**
	 * Increments the metric of the top element of {@link #stack} by
	 * {@link BigDecimal#ONE}.
	 */
	void inc() {
		inc(BigDecimal.ONE);
	}
}
