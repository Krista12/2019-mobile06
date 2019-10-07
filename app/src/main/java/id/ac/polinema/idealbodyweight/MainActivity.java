package id.ac.polinema.idealbodyweight;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import id.ac.polinema.idealbodyweight.fragments.AboutFragment;
import id.ac.polinema.idealbodyweight.fragments.BrocaIndexFragment;
import id.ac.polinema.idealbodyweight.fragments.MenuFragment;
import id.ac.polinema.idealbodyweight.fragments.ResultFragment;
import id.ac.polinema.idealbodyweight.fragments.bmiFragment;
import id.ac.polinema.idealbodyweight.util.BrocaIndex;

public class MainActivity extends AppCompatActivity implements
	MenuFragment.OnFragmentInteractionListener, BrocaIndexFragment.OnFragmentInteractionListener, ResultFragment.OnFragmentInteractionListener, bmiFragment.OnFragmentInteractionListener{
	// Deklarasikan atribut Fragment di sini
	private AboutFragment aboutFragment;
	private MenuFragment menuFragment;
	private ResultFragment resultFragment;
	private BrocaIndexFragment brocaIndexFragment;
	private bmiFragment bmiFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		aboutFragment = AboutFragment.newInstance("Krista Bella");
		menuFragment = new MenuFragment();
		resultFragment = new ResultFragment();
        brocaIndexFragment = new BrocaIndexFragment();
        bmiFragment = new bmiFragment();
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, menuFragment)
				.commit();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu, menu);
		return  true;
	}

	@Override
	public boolean onOptionsItemSelected(@NonNull MenuItem item) {
		// TODO: Tambahkan penanganan menu di sini
		if (item.getItemId() == R.id.menu_about){
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.fragment_container, aboutFragment)
					.addToBackStack(null)
					.commit();
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onBrocaIndexButtonClicked() {
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, brocaIndexFragment)
				.commit();
	}

	@Override
	public void onBodyMassIndexButtonClicked() {
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, bmiFragment)
				.commit();

	}

	@Override
	public void onFragmentInteraction(float index) {

	}

	@Override
	public void onCalculateBrocaIndexClicked(float index) {
        resultFragment.setInformation(String.format("Your ideal weight is %.2f kg", index));
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, resultFragment, "Broca")
                .commit();
	}



    @Override
    public void onTryAgainButtonClicked(String tag) {
		if (tag.equals("Broca")) {
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.fragment_container, brocaIndexFragment)
					.commit();
		} else if (tag.equals("bmi")){
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.fragment_container, bmiFragment)
					.commit();
		}
	}
	@Override
	public void onCalculateBodyMassIndexClicked(String result) {
		resultFragment.setInformation((String.format("Your Body Mass : " + result)));
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, resultFragment, "bmi")
				.commit();
	}
}
