package statistics;

import statistics.matcher.*;

class QueryBuilder {

    private Matcher matcher;

    public QueryBuilder() {
        this.matcher = new All();
    }

    public Matcher build() {
        Matcher matcher = this.matcher;
        this.matcher = new All();
        return matcher;
    }

    public QueryBuilder playsIn(String team) {
        this.matcher = new And(matcher, new PlaysIn(team));
        return this;
    }

    public QueryBuilder hasAtLeast(int i, String goals) {
        this.matcher = new And(matcher, new HasAtLeast(i, goals));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int i, String goals) {
        this.matcher = new And(matcher, new HasFewerThan(i, goals));
        return this;
    }

    public QueryBuilder oneOf(Matcher m1, Matcher m2) {
        this.matcher = new Or(m1, m2);
        return this;
    }

}
