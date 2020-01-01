package com.floyd.mapapptutorial

import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.clustering.ClusterItem

// ClusterItem을 구현하는 클래스
class MyItem(
    val _position: LatLng,
    val _title: String,
    val _snippet: String,
    val _icon: BitmapDescriptor
) : ClusterItem {

    override fun getSnippet(): String {
        return _snippet
    }

    override fun getTitle(): String {
        return _title
    }

    override fun getPosition(): LatLng {
        return _position
    }

    fun getIcon(): BitmapDescriptor {
        return _icon
    }

    // 두 인스턴스가 실질적으로 같은 것인지 판단.
    // 위도 경도 title snippet이 모두 같으면 같은 것으로 친다
    override fun equals(other: Any?): Boolean {
        if (other is MyItem) {
            return (other.position.latitude == _position.latitude
                    && other.position.longitude == _position.longitude
                    && other.title == _title
                    && other.snippet == _snippet)
        }
        return false
    }

    // equals 함수를 오버라이드 했다면 hashCode 함수도 해줘야 한다
    // 같은 객체는 같은 hash code를 반환해야 한다
    override fun hashCode(): Int {
        var hash = _position.latitude.hashCode() * 31
        hash = hash * 31 + _position.longitude.hashCode()
        hash = hash * 31 + _title.hashCode()
        hash = hash * 31 + _snippet.hashCode()
        return hash
    }
}