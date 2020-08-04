package com.spacecolony.refresh.fragment

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.spacecolony.refresh.MainActivity
import com.spacecolony.refresh.R
import com.spacecolony.refresh.adapter.ticket_adapter
import com.spacecolony.refresh.api.services.restAPIservices
import com.spacecolony.refresh.config.constant
import com.spacecolony.refresh.model.request.get_ticket_request
import com.spacecolony.refresh.model.ticket_icare
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    var apiService = restAPIservices()
    lateinit var LayoutManager: LinearLayoutManager
    lateinit var adapter: ticket_adapter
    lateinit var recycler: RecyclerView
    lateinit var dialog: AlertDialog

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        TicketRecycler.setHasFixedSize(true)
        LayoutManager = LinearLayoutManager(activity)
        TicketRecycler.layoutManager = LayoutManager

        TicketRecycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0 && (activity as MainActivity).bottomnavstatus()) {
                    (activity as MainActivity).setbottomnav(View.GONE)
                } else if (dy < 0) {
                    (activity as MainActivity).setbottomnav(View.VISIBLE)
                }
            }
        })
    }

    override fun onResume() {
        super.onResume()
        getTicket()
    }

    private fun getTicket() {
        var data = get_ticket_request(
            tag = constant.TAG().GET_TICKET_ICARE,
            last_index = 0,
            sort_by = "addtime",
            sort_type = "desc",
            limit = 10,
            id_user = "2013215989",
            table_name = ""
        )

        apiService.getTicket(data) {
            if (it?.Result?.ResultCode == 1) {
                adapter = ticket_adapter(
                    activity!!.baseContext,
                    it.Header.Tickets as MutableList<ticket_icare>
                )
                adapter.notifyDataSetChanged()
                TicketRecycler.adapter = adapter
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}