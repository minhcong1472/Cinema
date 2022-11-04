package Ptit.Cinema;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import Ptit.Cinema.model.LichChieu;

public class LichChieuTest {
	@Test
	public void PhongTest() {
		LichChieu lichchieu1 = new LichChieu();
		lichchieu1.setId(10);
		LichChieu lichchieu2 = new LichChieu();

		lichchieu2.setId(lichchieu1.getId());
		assertThat(lichchieu2.getId()).isEqualTo(lichchieu1.getId());
		lichchieu2.setId(20);
		assertThat(lichchieu1.getId()).isNotEqualTo(lichchieu2.getId());
		lichchieu1.setId(30);
		assertThat(lichchieu1.getId()).isNotEqualTo(lichchieu2.getId());
	}
}
