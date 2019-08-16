//
//  GetAPOD.swift
//  kosmos
//
//  Created by Robin Caroff on 13/08/2019.
//  Copyright © 2019 Maxime Lumeau. All rights reserved.
//

import Foundation
import kore

protocol GetApod {
    func getApod(completion: @escaping (APOD)->(), error: ()->())
}
