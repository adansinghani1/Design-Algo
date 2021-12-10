import java.util.*;

public class Autocomplete {

  public static void main(String[] args) {
    /*
    System.out.println(candidates(example, "c"));
    System.out.println(candidates(example, "ca"));
    System.out.println(candidates(example, "an"));
    System.out.println(candidates(example, ""));
    System.out.println(candidates(example, "deer"));
    System.out.println(candidates(example, "bean"));
    */
    TreeNode<Character> example = makeExample();

    // Q1 Examples
    //TreeNode<Character> endNode = findNode(example, "acn", 0);
    //System.out.println(endNode.getValue()); // should output 'n'
    //System.out.println(endNode.getChildren().get(0).getValue()); // should output 'e'

    //endNode = findNode(example, "notInTree", 0);
    //System.out.println(endNode); // should output null

    // Q2 Examples
    //List<String> exampleList = new ArrayList<>();
    //collectWords(example.getChildren().get(1), "", exampleList);
    System.out.println(candidates(example, "e"));; // should output ["eam", "eef", "ees"]

   // exampleList.clear();
    //collectWords(example.getChildren().get(1), "b", exampleList);
    System.out.println(candidates(example, "b")); // should output ["beam", "beef", "bees"]

    //exampleList.clear();
    //collectWords(example.getChildren().get(1), "mm", exampleList);
    System.out.println(candidates(example, "mm")); // should output ["mmeam", "mmeef", "mmees"]

    // Q3 Examples
    System.out.println(candidates(example, "c")); // Outputs ["cat", "cow", "cut"]
    System.out.println(candidates(example, "ca")); // Outputs ["cat"]
    System.out.println(candidates(example, "an")); // Outputs ["and", "andrew"]
 
    //// Outputs ["ace", "acne", "and", "andrew", "beam", "beef", "bees", "cat", "cow", "cut"]
    System.out.println(candidates(example, ""));
    System.out.println(candidates(example, "deer")); // Outputs []
    System.out.println(candidates(example, "bean")); // Outputs []
  }


  /*
   * Q1. findNode
   * Add your key ideas to this comment.
   * How did you approach the problem?
   * Why does your code work?
   */
   /*
  public static TreeNode<Character> findNode(TreeNode<Character> node, String prefix, int index) {
    throw new UnsupportedOperationException("findNode not yet written");
  }
  /*
   * Q2. collectWords
   * Add your key ideas to this comment.
   * How did you approach the problem?
   * Why does your code work?
   */
  /*
  public static void collectWords(TreeNode<Character> node, String prefix, List<String> results) {
    throw new UnsupportedOperationException("collectWords not yet written");
  }
  /*
   * Q3. candidates
   * Add your key ideas to this comment.
   * How did you approach the problem?
   For the candidates function I created two array lists
   * Why does your code work?
   */
  public static List<String> candidates(TreeNode<Character> root, String prefix) {
    List<String> list = new ArrayList();
    collectWords(root,list);
    List<String> res = new ArrayList();
    /*
    if (root.getValue() == '$' && prefix.charAt(0) == root.getChildren().get(0).getValue()){
        String rootLetter = prefix.substring(0,prefix.length() - 1);
        res.add(rootLetter);
        /*
        if(root.getChildren().get(0).getValue() == prefix.charAt(0)){
	return findNode(root.getChildren().get(0), prefix.substring(1),1);
    *
    }
    else
    {
    */
    for(int index = 0; index < list.size(); index ++){
        String word = list.get(index);
        if (prefix.length() < word.length() && word.substring(0,prefix.length()).equals(prefix)){
            res.add(list.get(index));
        }
    //throw new UnsupportedOperationException("candidates not yet written");
    }
    return res;
  }

private static void collectWords (TreeNode<Character> root, List<String> res){
    helperFunction(root,res,"");
}
private static void helperFunction(TreeNode<Character> root, List<String> res,String rootWord){
    /**
    if (root.getValue() == '$' && root.getChildren().get(0).getValue() == rootWord.charAt(0)){
        String rootLetter = rootWord.substring(0, rootWord.length());
        res.add(rootLetter);
    }
    */
    String emptyString = "";
    if (root.getValue() == '$' && rootWord != emptyString){
        res.add(rootWord);
    }
    else
    {
        for (TreeNode<Character> child : root.getChildren()){
            if(child.getValue() == '$'){
                helperFunction(child,res,rootWord);
            
            }
            else
            {
                helperFunction(child,res,rootWord+child.getValue());
            }
        }
    }
}

  private static TreeNode<Character> makeExample() {
    return
      new TreeNode('*', Arrays.asList(
        new TreeNode('a', Arrays.asList(
          new TreeNode('c', Arrays.asList(
            new TreeNode('e', Arrays.asList(
              new TreeNode('$')
            )),
          new TreeNode('n', Arrays.asList(
            new TreeNode('e', Arrays.asList(
              new TreeNode('$')
            ))
          ))
        )),
        new TreeNode('n', Arrays.asList(
          new TreeNode('d', Arrays.asList(
            new TreeNode('$'),
            new TreeNode('r', Arrays.asList(
              new TreeNode('e', Arrays.asList(
                new TreeNode('w', Arrays.asList(
                  new TreeNode('$')
                ))
              ))
            ))
          ))
        ))
      )),
      new TreeNode('b', Arrays.asList(
        new TreeNode('e', Arrays.asList(
          new TreeNode('a', Arrays.asList(
      	    new TreeNode('m', Arrays.asList(
              new TreeNode('$')
            ))
          )),
      	  new TreeNode('e', Arrays.asList(
       	    new TreeNode('f', Arrays.asList(
      	      new TreeNode('$')
      	    )),
	    new TreeNode('s', Arrays.asList(
	      new TreeNode('$')
	    ))
      	  ))
        ))
      )),
      new TreeNode('c', Arrays.asList(
        new TreeNode('a', Arrays.asList(
          new TreeNode('t', Arrays.asList(
	    new TreeNode('$')
          ))
        )),
        new TreeNode('o', Arrays.asList(
          new TreeNode('w', Arrays.asList(
            new TreeNode('$')
          ))
        )),
        new TreeNode('u', Arrays.asList(
          new TreeNode('t', Arrays.asList(
            new TreeNode('$')
          ))
        ))
      ))
    ));
  }

}
