package by.vsu.lab.task3.gem.comparators;

import java.util.Comparator;

import by.vsu.lab.task3.gem.Gem;

public class CompareByValue implements Comparator<Gem> {

    @Override
    public int compare(Gem arg0, Gem arg1) {
	return arg0.getValue().compareTo(arg1.getValue());
    }

}
