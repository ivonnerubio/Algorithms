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
        HorizontalLayout horizontal = new HorizontalLayout ();
        Button newArray = new Button("Generate New Array");
        newArray.setSizeFull();
        newArray.addClickListener(click -> {
            remove(horizontal);
            generated_array = generateArray();
            horizontal.add(new H1(Arrays.toString(generated_array)));
            //add(new H1(Arrays.toString(generated_array)));
            add(horizontal);

        });

        Button bubbleButton = new Button("Bubble Sort");
        bubbleButton.addClickListener(click -> {
            generated_array = bubbleSort(generated_array);

        });

        Button insertButton = new Button("Insert Sort");




        HorizontalLayout algLayout = new HorizontalLayout();
        algLayout.add(bubbleButton,insertButton);



        add(newArray, algLayout, horizontal);






        mainController cont = new mainController("ivonne");
        cont.testIvonne();


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

