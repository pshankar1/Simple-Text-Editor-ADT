class Main
{
  public static void main(String[] args){
  Main text=new  Main() ;
  text.inserting(5);
  text.inserting(12);
  text.inserting(11);
  text.inserting(19);

  System.out.println("Former element list");
  System.out.println(text.toString());
  
  System.out.println("List is Empty: "+text.isEmpty());
  
  System.out.println("Pointer moves left");
  text.left();
  System.out.println(text.toString());

 System.out.println("Pointer moves  right");
  text.right();
  
  System.out.println(text.toString());
  System.out.println("After deleting the prior element on list being pointed at!");
  text.delete();
  System.out.println(text.toString());
  
 }
 private Holders pointer;

 public Main()
 {
  pointer=null;
 }
/******
Goes to the front of insertinged elements
and sets the pointer to the first element
********/
 public boolean firstPart()
 {
  return pointer.initial==null;
 }

/*****
Checks if element list
is empty and pakes sure to return the pointer 
to a null value if needed 
******/
 public boolean isEmpty()
 {
  return pointer==null;
 }
 
/******
responsible for removing insertinged elements 
and reestablishing the pointer to the newer listed values  
pointer will move throughout it 
*********/
 public void delete()
 {
  if(pointer.next==null)
     {
      pointer = pointer.initial;
      if(pointer!=null)
         pointer.next=null;
     }
  else
     {
      pointer.next.initial = pointer.initial;
      if(pointer.initial!=null)
         pointer.initial.next = pointer.next;
      pointer=pointer.next;
     }
 }
/******
Goes to the end of insertinged elements
and sets the pointer to the last element
********/
 public boolean lastPart()
 {
  return pointer.next==null;
 }


/******
Responsible for 
insertinging elements to list 
and assinging the pointer throughout object
********/
 public void inserting(Object obj)
 {
  if(pointer==null)
     pointer = new Holders(null,obj,null);
  else if(pointer.next==null)
     {
      pointer.next = new Holders(pointer,obj,null);
      pointer = pointer.next;
     }
  else
     {
      pointer.next.initial = new Holders(pointer,obj,pointer.next);
      pointer.next = pointer.next.initial;
      pointer=pointer.next;
     }
 }



/*********
iterates the pointer to move 
right down on the list
********/
 public void right()
 {
  pointer = pointer.next;
 }
/*******
Will move the pointer lefts or left on the list
*****/
 public void left()
 {
  pointer = pointer.initial;
 }

 public Object current()
 {
  return pointer.content;
 }
 
 public String toString()
 {
  Holders count;
  String printy="";
  if(pointer!=null)
     {
      for(count=pointer; count.initial!=null; count=count.initial);
      for(;count!=null;count=count.next)
         {
          if(count==pointer)
             printy+="> ";
          else
             printy+="  ";
          printy+=count.content+"\n";
         }
     }
  return printy;
 }

 private static class Holders
 {
  Holders initial,next;
  Object content;

  Holders(Holders point,Object o,Holders val)
  {
   initial=point;
   content=o;
   next=val;
  }
 }
 
}