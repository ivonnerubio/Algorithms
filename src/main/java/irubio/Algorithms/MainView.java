package irubio.Algorithms;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Random;

@Route("")
@PageTitle("Algorithm Visualizer")
public class MainView extends VerticalLayout {

    int[] generated_array;
    public MainView(){
        Button newArray = new Button("Generate New Array");
        newArray.addClickListener(click -> {
            generateArray();
            generated_array = generateArray();
            add(new H1(Arrays.toString(generated_array)));
        });
        mainController cont = new mainController("ivonne");
        cont.testIvonne();
        Button bubbleButton = new Button("Bubble Sort");
        bubbleButton.addClickListener(click -> {
            add(new H1(Arrays.toString(bubbleSort(generated_array))));
        });
        Button insertButton = new Button("Insertion Sort");
        insertButton.addClickListener(click -> {
            add(new H1(Arrays.toString(insertSort(generated_array))));
        });
        Button quickButton = new Button("Quick Sort");



        VerticalLayout vertical = new VerticalLayout();
        vertical.add(bubbleButton, insertButton, quickButton,new H1(cont.testIvonne()));


        HorizontalLayout horizontal = new HorizontalLayout ();
        horizontal.add(vertical, newArray);
        add(horizontal, new H1(Arrays.toString(generateArray())));









    }

    @RequestMapping("/main")
    public String example(){
        return "main";
    }


    public int[] bubbleSort(int[] input){
        for(int i=0; i< input.length; i++){
            for(int j=0; j<input.length;j++){
                if(input[i] < input[j]){
                    swap(input, i, j);
                }
            }
        }
        return input;
    }

    public int[] insertSort(int[] input){
        return input;
    }


    public int[] generateArray(){
        int[] inputArray = new int[10];
        Random rd = new Random();
        for(int i=0; i<inputArray.length; i++){
            inputArray[i] = rd.nextInt(100);
        }
        return inputArray;
    }

    public static void swap(int[] array, int i, int j){
        if(i==j){
            return;
        }

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
