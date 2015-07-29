package main.java.com.github.vamem9z.dci.core.data.daos;

import java.util.Random;

public interface Dao {
	default int randInt(int min, int max) {
	    Random rand = new Random();
	    
	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
}
