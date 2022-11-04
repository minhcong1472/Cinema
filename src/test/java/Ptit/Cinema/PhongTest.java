package Ptit.Cinema;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import Ptit.Cinema.model.Phong;

public class PhongTest {

	@Test
	public void PhongTest() {
		Phong phong1 = new Phong();
		phong1.setId(10);
		Phong phong2 = new Phong();

		phong2.setId(phong1.getId());
		assertThat(phong1.getId()).isEqualTo(phong2.getId());
		phong2.setId(20);
		assertThat(phong1.getId()).isNotEqualTo(phong2.getId());
		phong1.setId(30);
		assertThat(phong1.getId()).isNotEqualTo(phong2.getId());
	}
}
