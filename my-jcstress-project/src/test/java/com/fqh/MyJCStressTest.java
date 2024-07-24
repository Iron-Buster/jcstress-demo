package com.fqh;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.*;


@JCStressTest
@Outcome(id = "0, 0", expect = Expect.ACCEPTABLE, desc = "Default outcome")
@Outcome(id = "1, 0", expect = Expect.ACCEPTABLE, desc = "Actor 1 incremented")
@Outcome(id = "0, 1", expect = Expect.ACCEPTABLE, desc = "Actor 2 incremented")
@Outcome(id = "1, 1", expect = Expect.ACCEPTABLE, desc = "Both actors incremented")
@State
public class MyJCStressTest {

    int x;

    @Actor
    public void actor1(I_Result r) {
        r.r1 = x++;
    }

    @Actor
    public void actor2(I_Result r) {
        r.r1 = x++;
    }

    @Actor
    public void actor3() { x++; }
}
