package com.jpark.takehome.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jpark.takehome.adapter.UserAdapter;
import com.jpark.takehome.model.ServiceWrapper;
import com.jpark.takehome.model.UserModel;
import com.jpark.takehome.model.UserService;
import com.jpark.takehome.R;
import com.jpark.takehome.common.ExceptionHandler;

import java.util.List;

import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetroFragment extends Fragment {
    private View view = null;
    private RecyclerView recyclerView;
    private UserAdapter adapter;
    private RealmResults<UserModel> users;
    private Realm realm;
    private Context context;
    private Disposable disposable;
    private PublishSubject<String> subject;
    public RetroFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(view ==null)
            view = inflater.inflate(R.layout.fragment_retro, container, false);
        Realm.init(context);
        realm = Realm.getDefaultInstance();
        //Progress 처리
        ProgressDialog dialog = new ProgressDialog(context);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("Loading...");
        dialog.show();
        ServiceWrapper wrapper = new UserService();

        Call<List<UserModel>> result = wrapper.getUsers();
        result.enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response)  {
                if(response.isSuccessful()) {
                    //realm 사용
                    realm.beginTransaction();
                    realm.copyToRealmOrUpdate(response.body());
                    realm.commitTransaction();
                    // 데이터 불러온 후 recyclerView init
                    init();
                }else {
                    // 정상적이지 않을경우 message 에 오류내용이 담겨온다.
                    ExceptionHandler.getInstance().onHttpException(response.code());
                }
                dialog.dismiss();
            }
            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {
                //아예 인터넷이 연결되지 않았을경우
                ExceptionHandler.getInstance().showErroMessage(t.getMessage());
                dialog.dismiss();
            }
        });




        return view;
    }

    public void init(){
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_user);
        users = realm.where(UserModel.class)
                .findAll();
        adapter = new UserAdapter(users);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        //prefetch 사용
        manager.setInitialPrefetchItemCount(5);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        realm.executeTransaction(realm1 -> users.deleteAllFromRealm());
    }

}
