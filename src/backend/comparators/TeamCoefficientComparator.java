package backend.comparators;

import backend.basics.Team;

import java.util.Comparator;

public class TeamCoefficientComparator implements Comparator<Team> {

    @Override
    public int compare(Team t1, Team t2) {
        return Float.compare(t2.getTeamCoefficient(), t1.getTeamCoefficient());
    }
}
