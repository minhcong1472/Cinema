package Ptit.Cinema;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import Ptit.Cinema.model.Phim;

public class PhimTest {

	@Test
	void PhimTest() {
		Phim phim1 = new Phim();
		phim1.setId(10);
		Phim phim2 = new Phim();
		phim2.setId(phim1.getId());
		assertThat(phim1.getId()).isEqualTo(phim2.getId());
		phim2.setId(20);
		assertThat(phim1.getId()).isNotEqualTo(phim2.getId());
		phim1.setId(30);
		assertThat(phim1.getId()).isNotEqualTo(phim2.getId());
	}
}
