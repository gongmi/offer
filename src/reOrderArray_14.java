import java.util.Arrays;
//和书上不一样 这个题是要稳定的排序
public class reOrderArray_14 {
    public void reOrderArray(int [] array) {
        int[] temp=new int[array.length];
        int k=0;
        for(int i:array)
            if((i&1)==1)
                temp[k++]=i;
         for(int i:array)
            if((i&1)==0)
                temp[k++]=i;
        for(int i=0;i<array.length;i++)
            array[i]=temp[i];//最后必须这样把原来array指向的数组里的元素改掉
        
//        这两种方法其实是一样的 第一个是新建一个数组 它内容和temp一样 然后让array指向它
//        第二个是让array指向temp 但是原来那个数组没变 这是不行的
//        array=Arrays.copyOf(temp, array.length);
//        array=temp;
    }
}
