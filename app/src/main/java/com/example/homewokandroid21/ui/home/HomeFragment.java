package com.example.homewokandroid21.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.homewokandroid21.R;
import com.example.homewokandroid21.TaskAdapter;
import com.example.homewokandroid21.TaskModel;
import com.example.homewokandroid21.databinding.FragmentFormBinding;
import com.example.homewokandroid21.databinding.FragmentHomeBinding;

import org.jetbrains.annotations.NotNull;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private TaskAdapter taskAdapter;
    private FragmentHomeBinding binding;

    @Override
    public void onCreate(@Nullable  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        taskAdapter = new TaskAdapter();
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        setAdapter();
        setResultListener();
        return root;
    }
    public void setAdapter(){
        binding.rv.setAdapter(taskAdapter);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;

    }

    private void setResultListener() {
        getParentFragmentManager().setFragmentResultListener("task",
                getViewLifecycleOwner(),
                new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                TaskModel taskModel = (TaskModel) result.getSerializable("model");
                if (taskModel != null){
                    taskAdapter.addInfo(taskModel);
                    taskAdapter.notifyDataSetChanged();
                }
            }
        });
    }
}