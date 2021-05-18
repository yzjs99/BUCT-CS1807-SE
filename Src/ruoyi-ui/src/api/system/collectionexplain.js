import request from '@/utils/request'

// 查询收藏品讲解列表
export function listCollectionexplain(query) {
  return request({
    url: '/system/collectionexplain/list',
    method: 'get',
    params: query
  })
}

// 查询收藏品讲解详细
export function getCollectionexplain(id) {
  return request({
    url: '/system/collectionexplain/' + id,
    method: 'get'
  })
}

// 新增收藏品讲解
export function addCollectionexplain(data) {
  return request({
    url: '/system/collectionexplain',
    method: 'post',
    data: data
  })
}

// 修改收藏品讲解
export function updateCollectionexplain(data) {
  return request({
    url: '/system/collectionexplain',
    method: 'put',
    data: data
  })
}

// 删除收藏品讲解
export function delCollectionexplain(id) {
  return request({
    url: '/system/collectionexplain/' + id,
    method: 'delete'
  })
}

// 导出收藏品讲解
export function exportCollectionexplain(query) {
  return request({
    url: '/system/collectionexplain/export',
    method: 'get',
    params: query
  })
}
  export function getCollectionImage(id) {
    //return "/dev-api/system/collectionexplain/select/pic/" + id;
    return "/prod-api/system/collectionexplain/select/pic/" + id;
  }
  export function getCollectionVoice(id) {
    //return "/dev-api/system/collectionexplain/select/voice/" + id;
    return "/prod-api/system/collectionexplain/select/voice/" + id;
  }
