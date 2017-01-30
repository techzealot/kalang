/*

*/
package kalang.ast;
import java.util.*;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import kalang.core.*;
public class LoopStmt extends Statement{
    
    //public final List<Statement> initStmts = new LinkedList<>();

    private BlockStmt loopBody;
    
    @Nullable
    public ExprNode preConditionExpr;
    
    @Nullable
    public ExprNode postConditionExpr;
    
    
    public LoopStmt(@Nullable BlockStmt loopBody,@Nullable ExprNode preConditionExpr,@Nullable ExprNode postConditionExpr){
        this.loopBody = loopBody==null ? new BlockStmt() : loopBody;
        this.preConditionExpr = preConditionExpr;
        this.postConditionExpr = postConditionExpr;
    }
    
    @Override
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        //addChild(ls,initStmts);
        addChild(ls,loopBody);
        addChild(ls,preConditionExpr);
        addChild(ls,postConditionExpr);
        return ls;
    }

    @Nonnull
    public BlockStmt getLoopBody() {
        return loopBody;
    }
    
}