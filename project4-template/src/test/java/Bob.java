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

}
