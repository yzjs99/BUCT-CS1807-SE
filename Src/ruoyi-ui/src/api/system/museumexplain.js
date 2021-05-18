import request from '@/utils/request'

// 查询博物馆讲解列表
export function listMuseumexplain(query) {
  return request({
    url: '/system/museumexplain/list',
    method: 'get',
    params: query
  })
}

// 查询博物馆讲解详细
export function getMuseumexplain(id) {
  return request({
    url: '/system/museumexplain/' + id,
    method: 'get'
  })
}

// 新增博物馆讲解
export function addMuseumexplain(data) {
  return request({
    url: '/system/museumexplain',
    method: 'post',
    data: data
  })
}

// 修改博物馆讲解
export function updateMuseumexplain(data) {
  return request({
    url: '/system/museumexplain',
    method: 'put',
    data: data
  })
}

// 删除博物馆讲解
export function delMuseumexplain(id) {
  return request({
    url: '/system/museumexplain/' + id,
    method: 'delete'
  })
}

// 导出博物馆讲解
export function exportMuseumexplain(query) {
  return request({
    url: '/system/museumexplain/export',
    method: 'get',
    params: query
  })
}
export function getMuseumImage(id) {
  //return "/dev-api/system/museumexplain/select/pic/" + id;
  return "/prod-api/system/museumexplain/select/pic/" + id;
}

export function getMuseumVoice(id) {
  //return "/dev-api/system/museumexplain/select/voice/" + id;
  return "/prod-api/system/museumexplain/select/voice/" + id;
}

