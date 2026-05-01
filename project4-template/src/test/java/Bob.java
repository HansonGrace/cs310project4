import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import clojure.java.api.Clojure;

// Bob made these tests

class Bob {
	@BeforeAll
	static void requires() {
        var require = Clojure.var("clojure.core", "require");
        require.invoke(Clojure.read("Lauren"));
	}

	@Test
	void testLaurenThirdClojure() {
		var third = Clojure.var("Lauren", "third");
		var list = List.of("A", "B", "C", "D", "E");
		assertEquals("C", third.invoke(list));
	}

	@Test
	void testEthanThirdJava() {
		var list = List.of("A", "B", "C", "D", "E");
		assertEquals("C", Ethan.third(list));
	}

	//grace made these
	//member JUNIT tests

	@Test
	void testLaurenMemberClojureEmpty() {
		var member = Clojure.var("Lauren", "member");
		assertEquals(false, member.invoke("A", List.of()));
	}

	@Test
	void testLaurenMemberClojureFoundHead() {
		var member = Clojure.var("Lauren", "member");
		assertEquals(true, member.invoke("A", List.of("A", "B", "C")));
	}

	@Test
	void testLaurenMemberClojureFoundMiddle() {
		var member = Clojure.var("Lauren", "member");
		assertEquals(true, member.invoke("B", List.of("A", "B", "C")));
	}

	@Test
	void testLaurenMemberClojureFoundTail() {
		var member = Clojure.var("Lauren", "member");
		assertEquals(true, member.invoke("C", List.of("A", "B", "C")));
	}

	@Test
	void testLaurenMemberClojureNotFound() {
		var member = Clojure.var("Lauren", "member");
		assertEquals(false, member.invoke("Z", List.of("A", "B", "C")));
	}

	//append JUNIT tests

	@Test
	void testLaurenAppendClojureBothEmpty() {
		var append = Clojure.var("Lauren", "append");
		assertEquals(List.of(), append.invoke(List.of(), List.of()));
	}

	@Test
	void testLaurenAppendClojureFirstEmpty() {
		var append = Clojure.var("Lauren", "append");
		assertEquals(List.of("A", "B"), append.invoke(List.of(), List.of("A", "B")));
	}

	@Test
	void testLaurenAppendClojureSecondEmpty() {
		var append = Clojure.var("Lauren", "append");
		assertEquals(List.of("A", "B"), append.invoke(List.of("A", "B"), List.of()));
	}

	@Test
	void testLaurenAppendClojureTypicalConcat() {
		var append = Clojure.var("Lauren", "append");
		assertEquals(List.of("A", "B", "C", "D"), append.invoke(List.of("A", "B"), List.of("C", "D")));
	}

	@Test
	void testLaurenAppendClojureSingletons() {
		var append = Clojure.var("Lauren", "append");
		assertEquals(List.of("A", "B"), append.invoke(List.of("A"), List.of("B")));
	}

	//grace made these
	//map JUNIT tests

	@Test
	void testLaurenMapClojureEmpty() {
		var map = Clojure.var("Lauren", "map");
		var inc = Clojure.var("clojure.core", "inc");
		assertEquals(List.of(), map.invoke(inc, List.of()));
	}

	@Test
	void testLaurenMapClojureSingleElement() {
		var map = Clojure.var("Lauren", "map");
		var inc = Clojure.var("clojure.core", "inc");
		assertEquals(List.of(6L), map.invoke(inc, List.of(5)));
	}

	@Test
	void testLaurenMapClojureIncrement() {
		var map = Clojure.var("Lauren", "map");
		var inc = Clojure.var("clojure.core", "inc");
		assertEquals(List.of(2L, 3L, 4L), map.invoke(inc, List.of(1, 2, 3)));
	}

	@Test
	void testLaurenMapClojureStringify() {
		var map = Clojure.var("Lauren", "map");
		var str = Clojure.var("clojure.core", "str");
		assertEquals(List.of("1", "2", "3"), map.invoke(str, List.of(1, 2, 3)));
	}

	@Test
	void testLaurenMapClojureLargerList() {
		var map = Clojure.var("Lauren", "map");
		var inc = Clojure.var("clojure.core", "inc");
		assertEquals(List.of(11L, 21L, 31L, 41L), map.invoke(inc, List.of(10, 20, 30, 40)));
	}

	//same JUNIT tests

	@Test
	void testLaurenSameClojureBothEmpty() {
		var same = Clojure.var("Lauren", "same");
		assertEquals(true, same.invoke(List.of(), List.of()));
	}

	@Test
	void testLaurenSameClojureFirstEmpty() {
		var same = Clojure.var("Lauren", "same");
		assertEquals(false, same.invoke(List.of(), List.of("A")));
	}

	@Test
	void testLaurenSameClojureSecondEmpty() {
		var same = Clojure.var("Lauren", "same");
		assertEquals(false, same.invoke(List.of("A"), List.of()));
	}

	@Test
	void testLaurenSameClojureEqualLists() {
		var same = Clojure.var("Lauren", "same");
		assertEquals(true, same.invoke(List.of("A", "B", "C"), List.of("A", "B", "C")));
	}

	@Test
	void testLaurenSameClojureDifferentLength() {
		var same = Clojure.var("Lauren", "same");
		assertEquals(false, same.invoke(List.of("A", "B"), List.of("A", "B", "C")));
	}

	@Test
	void testLaurenSameClojureDifferentElement() {
		var same = Clojure.var("Lauren", "same");
		assertEquals(false, same.invoke(List.of("A", "X", "C"), List.of("A", "B", "C")));
	}

}
