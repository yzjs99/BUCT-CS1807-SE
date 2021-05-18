import request from '@/utils/request'

// 查询博物馆收藏列表
export function listMuseumcollection(query) {
  return request({
    url: '/system/museumcollection/list',
    method: 'get',
    params: query
  })
}

// 查询博物馆收藏详细
export function getMuseumcollection(id) {
  return request({
    url: '/system/museumcollection/' + id,
    method: 'get'
  })
}

// 新增博物馆收藏
export function addMuseumcollection(data) {
  return request({
    url: '/system/museumcollection',
    method: 'post',
    data: data
  })
}

// 修改博物馆收藏
export function updateMuseumcollection(data) {
  return request({
    url: '/system/museumcollection',
    method: 'put',
    data: data
  })
}

// 删除博物馆收藏
export function delMuseumcollection(id) {
  return request({
    url: '/system/museumcollection/' + id,
    method: 'delete'
  })
}

// 导出博物馆收藏
export function exportMuseumcollection(query) {
  return request({
    url: '/system/museumcollection/export',
    method: 'get',
    params: query
  })
}