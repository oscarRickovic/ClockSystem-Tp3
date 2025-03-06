package org.example.notimmediate;


import org.example.component.StopWatch;
import org.example.utility.Time;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class StopWatchTest {
	
	private StopWatch sw;

	@BeforeEach
	void setUp() {
		sw = new StopWatch(); }
	
	@Test
	void tickTest() throws InterruptedException {
		sw.start();
		Thread.sleep(2100);
		sw.stop();
		assertEquals(sw.getTime(), new Time(0, 0, 2));
		}
	
	@Test
	void resetingTest() throws InterruptedException {
		sw.start();
		Thread.sleep(2000);
		sw.stop();
		Time previous = sw.getTime();
		sw.reset();
		assertFalse(previous.isZero());
		Time actual = sw.getTime();
		assertTrue(actual.isZero());
		}
	}
