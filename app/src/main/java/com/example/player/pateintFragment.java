package com.example.player;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link pateintFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class pateintFragment extends Fragment {
  private EditText Name,Id,Birthday,Status,Allergic;
  private TextView msg;
    private View objectpatiennt;
    private FirebaseFirestore db;

  private Button btn;
    private void attachComponents() {
        btn = objectpatiennt.findViewById(R.id.ptbtn);
        Name = objectpatiennt.findViewById(R.id.ptname);
        Id = objectpatiennt.findViewById(R.id.ptid);
        Birthday = objectpatiennt.findViewById(R.id.ptbirthday);
        Status = objectpatiennt.findViewById(R.id.ptstatus);
        Allergic = objectpatiennt.findViewById(R.id.ptallergic);
        msg=objectpatiennt.findViewById(R.id.ptmsg);
        db=FirebaseFirestore.getInstance();
        String name= Name.getText().toString();
        String id= Id.getText().toString();
        String birthday= Birthday.getText().toString();
        String status= Status.getText().toString();
        String allergic= Allergic.getText().toString();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, Object> patient = new HashMap<>();
                patient.put("name", name);
                patient.put("id", id);
                patient.put("birthday", birthday);
                patient.put("status", status);
                patient.put("allergic", allergic);
                db.collection("user")
                        .add(patient);
            }
        });
    }
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public pateintFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment pateintFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static pateintFragment newInstance(String param1, String param2) {
        pateintFragment fragment = new pateintFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
   public void Valid()
   {
       if(!Name.getText().toString().isEmpty()&&!Id.getText().toString().isEmpty()&&!Birthday.getText().toString().isEmpty()&&!Allergic.getText().toString().isEmpty()&&!Status.getText().toString().isEmpty())
           Toast.makeText(getContext(), "the info have been succsesfully received", Toast.LENGTH_SHORT).show();
       else
           Toast.makeText(getContext(), "some feilds are missing", Toast.LENGTH_SHORT).show();

   }
   private void Alert()
   {
     if (Allergic.getText().toString()=="Moxipen"||Allergic.getText().toString()=="moxipen"||Allergic.getText().toString()=="DWC"||Allergic.getText().toString()=="dwc")
         msg.setVisibility(View.VISIBLE);

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
            objectpatiennt=inflater.inflate(R.layout.fragment_pateint,container,false);
            attachComponents();

            return objectpatiennt;
        }
}