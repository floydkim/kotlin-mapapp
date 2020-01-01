package com.floyd.mapapptutorial

import android.content.Context
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.MarkerOptions
import com.google.maps.android.clustering.ClusterManager
import com.google.maps.android.clustering.view.DefaultClusterRenderer

// 마커 렌더하는 작업을 담당하는 ClusterRenderer 클래스
// DefaultClusterRenderer 를 상속
class ClusterRenderer(context: Context?, map: GoogleMap?, clusterManager: ClusterManager<MyItem>?) :
    DefaultClusterRenderer<MyItem>(context, map, clusterManager) {

    init {
        // 전달받은 clusterManager 객체에 renderer 를 자신으로 지정
        clusterManager?.renderer = this
    }

    // 클러스터 아이템이 렌더되기 전 호출되는 함수
    override fun onBeforeClusterItemRendered(item: MyItem?, markerOptions: MarkerOptions?) {
        // 마커 아이콘 지정
        markerOptions?.icon(item?.getIcon())
        markerOptions?.visible(true)
    }
}