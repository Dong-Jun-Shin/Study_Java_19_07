package javafx_control.exam06_chart;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;

public class RootController implements Initializable{
	@FXML private PieChart pieChart;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<PieChart.Data> pieChartData 
		= FXCollections.observableArrayList(
					new PieChart.Data("AWT", 10),
					new PieChart.Data("Swing", 30),
					new PieChart.Data("SWT", 25),
					new PieChart.Data("JavaFX", 35)
				);
		pieChart.setTitle("자바UI");
		pieChart.setData(pieChartData);
		pieChart.setLegendSide(Side.BOTTOM);
		//원형에 상대적인 범례의 기본 위치를 변경
	}

}
