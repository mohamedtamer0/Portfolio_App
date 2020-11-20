package com.example.portfolioapp.portfolio;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.portfolioapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PortfolioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PortfolioFragment extends Fragment implements PortfolioCallback {

    List<PortfolioItem> mdata;
    RecyclerView rv_portfolio;
    PortfolioAdapter portfolioAdapter ;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PortfolioFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PortfolioFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PortfolioFragment newInstance(String param1, String param2) {
        PortfolioFragment fragment = new PortfolioFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_portfolio, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rv_portfolio = view.findViewById(R.id.rv_portfolio);
        // create a list of portfolio items
        mdata = new ArrayList<>();





        mdata.add(new PortfolioItem(R.drawable.project0));
        mdata.add(new PortfolioItem(R.drawable.project1));
        mdata.add(new PortfolioItem(R.drawable.project2));
        mdata.add(new PortfolioItem(R.drawable.project3));
        mdata.add(new PortfolioItem(R.drawable.project4));
        mdata.add(new PortfolioItem(R.drawable.project5));
        mdata.add(new PortfolioItem(R.drawable.project6));
        mdata.add(new PortfolioItem(R.drawable.project7));
        mdata.add(new PortfolioItem(R.drawable.project8));


        portfolioAdapter = new PortfolioAdapter(mdata,this);

        // setup grid recyclerview
        rv_portfolio.setLayoutManager(new GridLayoutManager(getActivity(),3));
        rv_portfolio.setAdapter(portfolioAdapter);

    }

    @Override
    public void onPortfolioItemClick(int pos) {
        //handle click listener event when portfolio item clicked

        // first we need to create a fragment bottom sheet instance

        PortfolioFragmentDetails portfolioFragmentDetails =
                new PortfolioFragmentDetails();

        // now we need to send portfolio item to portfolio dialog fragment
        // we will use bundle for that
        // also we need our portfolio item data class to implement serializable interface so we can send it

        Bundle bundle = new Bundle();
        bundle.putSerializable("object",mdata.get(pos));
        portfolioFragmentDetails.setArguments(bundle);

        // now let's open the portfolio bottom sheet fregment

        portfolioFragmentDetails.show(getActivity().getSupportFragmentManager(),"tagname");

        //now we done opening the bottom sheet let's test it out
        // ok everthing goes well
        // let's set the data in details fragment
    }
}