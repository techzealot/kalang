import compilier.*
import jast.ast.*
import kalang.antlr.KalangLexer
import kalang.antlr.KalangParser
import kalang.core.VarObject
import kalang.core.VarTable
import kava.antlr.*
import kava.compiler.Optimizer;
import kava.compiler.TheKavaVisitor;
import kava.compiler4j.Register2Stack
import kava.opcode.Op
import kava.opcode.ClassObject
import kava.vm.TheKavaExecutor

import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTree

class Application {
	static void main(args) {
		def input = '''\
import java.util.*;
class  kava {
  var f as int = 123;
  var f2;
  
  var func() as int{
    var a as int=3;
    var l as long = 3;
	var str = "hehe";
    var map = new HashMap();
    map.put("a",str);
    var b;
    a= a + 1;
    l = l + 1;
    //b.func(a);
    func2(a);
    func2(l);
    return (int)a;
  }
  var func2(p as long){
    f = 123;
    for(var i as int=0;i<10;i++){
      p++;
    }
	func2(p);
  }
}
''';

		def astLoader = new JavaAstLoader();
		def cpl = new KalangCompiler(astLoader);
		cpl.addSource("kava",input)
		cpl.compile();
		def classes = cpl.getCompiledClasses();
		def cls = classes[0]
		
		//println names
		//println cls;
		//def a2j = new Ast2Java();
		//println a2j.visit(cls);
		//def parseTrees = visitor.getParseTreeMap();
		
		//def ast = AstBuilder.build(String.class);
		//println a2j.visit(ast)
	}
}